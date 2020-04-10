package com.xzsd.pc.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 分库策略类
 */
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {

    @Override
    public String doEqualSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        for (String each : databaseNames) {
//            if (each.endsWith(Long.valueOf(shardingValue.getValue()) % 2 + "")) {
//                return each;
//            }
            if (each.endsWith("0")) {
                if(Long.valueOf(shardingValue.getValue())<=10000){
                    return each;
                }
            }else if (each.endsWith("1")) {
                if(Long.valueOf(shardingValue.getValue())>10000){
                    return each;
                }
            } else {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
        for (String value : shardingValue.getValues()) {
            for (String each : databaseNames) {
                if (each.endsWith("0")) {
                    if(Long.valueOf(value)<=10000){
                        result.add(value);
                    }
                }else if (each.endsWith("1")) {
                    if(Long.valueOf(value)>10000){
                        result.add(value);
                    }
                } else {
                    result.add(value);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
//        Range<String> range = shardingValue.getValueRange();
//        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
//            for (String each : databaseNames) {
//                if (each.endsWith(i % 2 + "")) {
//                    result.add(each);
//                }
//            }
//        }
        return result;
    }

}
