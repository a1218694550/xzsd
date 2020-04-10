package com.xzsd.pc.util.image;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.List;

public class CosClient {
        private String secretId = "AKIDnYTAcnakMjusb5NPK0c9WeW9YicI97Ax" ;
        private String secretKey = "hIo8CzavzyGQJ7HtIRSM3kDQO9XfYDdo";
        private static COSClient cosClient;
        // 指定要上传到的存储桶
        String bucketName = "book-store-1300963863";
        // 指定要上传到 COS 上对象键
        String key = "AKIDnYTAcnakMjusb5NPK0c9WeW9YicI97Ax";
        public CosClient() {
            // 1 初始化用户身份信息（secretId, secretKey）。
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
            Region region = new Region("ap-guangzhou");
            ClientConfig clientConfig = new ClientConfig(region);
            // 3 生成 cos 客户端。
            cosClient = new COSClient(cred, clientConfig);
        }
        public Bucket createBucket(){
            //创建存储桶
            String bucket = "book-store-1300963863"; //存储桶名称，格式：BucketName-APPID
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucket);
            // 设置 bucket 的权限为 Private(私有读写), 其他可选有公有读私有写, 公有读写
            createBucketRequest.setCannedAcl(CannedAccessControlList.PublicReadWrite);
            Bucket bucketResult=null;
            try{
                bucketResult = cosClient.createBucket(createBucketRequest);
            } catch (CosServiceException serverException) {
                serverException.printStackTrace();
            } catch (CosClientException clientException) {
                clientException.printStackTrace();
            }
            return bucketResult;
        }
        public boolean deleteBucket(){
            // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
            cosClient.deleteObject(bucketName, key);
            return true;
        }
        public void lookBucket(){
            /**
             * 查看用户存储桶列表
             */
            List<Bucket> buckets = cosClient.listBuckets();
            for (Bucket bucketElement : buckets) {
                String bucketName = bucketElement.getName();
                System.out.println("bucketName -> "+bucketName);
                String bucketLocation = bucketElement.getLocation();
                System.out.println("bucketLocation -> "+bucketLocation);
            }
        }
        public boolean upImage(String pathname){
            // 指定要上传的文件
            File localFile = new File(pathname);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            return true;
        }
        public void selectImg(){
            // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
            bucketName = "book-store-1300963863";
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
            // 设置bucket名称
            listObjectsRequest.setBucketName(bucketName);
            // prefix表示列出的object的key以prefix开始
            listObjectsRequest.setPrefix("images/");
            // deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
            listObjectsRequest.setDelimiter("/");
            // 设置最大遍历出多少个对象, 一次listobject最大支持1000
            listObjectsRequest.setMaxKeys(1000);
            ObjectListing objectListing = null;
            do {
                try {
                    objectListing = cosClient.listObjects(listObjectsRequest);
                } catch (CosServiceException e) {
                    e.printStackTrace();
                    return;
                } catch (CosClientException e) {
                    e.printStackTrace();
                    return;
                }
                // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
                List<String> commonPrefixs = objectListing.getCommonPrefixes();

                // object summary表示所有列出的object列表
                List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
                for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                    // 文件的路径key
                    String Filekey = cosObjectSummary.getKey();
                    // 文件的etag
                    String etag = cosObjectSummary.getETag();
                    // 文件的长度
                    long fileSize = cosObjectSummary.getSize();
                    // 文件的存储类型
                    String storageClasses = cosObjectSummary.getStorageClass();
                }
                String nextMarker = objectListing.getNextMarker();
                listObjectsRequest.setMarker(nextMarker);
            } while (objectListing.isTruncated());
        }
        public void downImage(){
            // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
            // 方法1 获取下载输入流
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
            COSObject cosObject = cosClient.getObject(getObjectRequest);
            COSObjectInputStream cosObjectInput = cosObject.getObjectContent();

            // 方法2 下载文件到本地
            String outputFilePath = "exampleobject";
            File downFile = new File(outputFilePath);
            getObjectRequest = new GetObjectRequest(bucketName, key);
            ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
        }

    public static void main(String[] args) {
        CosClient cosClient = new CosClient();
        cosClient.lookBucket();
    }
}
