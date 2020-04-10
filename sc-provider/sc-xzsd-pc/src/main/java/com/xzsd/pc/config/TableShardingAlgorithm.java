package com.xzsd.pc.config;


import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 分表策略类
 */
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<String> {

    @Override
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        for (String each : tableNames) {
            long num = Long.valueOf(shardingValue.getValue());
            if (each.endsWith("0")) {
                if (num<=5000 && num >=0){
                    return each;
                }else if (num<=15000 && num >10000){
                    return each;
                }
            }else if (each.endsWith("1")) {
                if (num<=10000 && num >5000){
                    return each;
                }else if (num<=20000 && num >15000){
                    return each;
                }
            }else {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        for (String value : shardingValue.getValues()) {
            for (String each : tableNames) {
                long num = Long.valueOf(shardingValue.getValue());
                if (each.endsWith("0")) {
                    if (num<=5000 && num >=0){
                        result.add(each);
                    }else if (num<=15000 && num >10000){
                        result.add(each);
                    }
                }else if (each.endsWith("1")) {
                    if (num<=10000 && num >5000){
                        result.add(each);
                    }else if (num<=20000 && num >15000){
                        result.add(each);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        Range<String> range = (Range<String>) shardingValue.getValueRange();
        for (Long num = Long.valueOf(range.lowerEndpoint()); num <= Long.valueOf(range.upperEndpoint()); num++) {
            for (String each : tableNames) {
                if (each.endsWith("0")) {
                    if (num<=5000 && num >=0){
                        result.add(each);
                    }else if (num<=15000 && num >10000){
                        result.add(each);
                    }
                }else if (each.endsWith("1")) {
                    if (num<=10000 && num >5000){
                        result.add(each);
                    }else if (num<=20000 && num >15000){
                        result.add(each);
                    }
                }
            }
        }
        return result;
    }
}
