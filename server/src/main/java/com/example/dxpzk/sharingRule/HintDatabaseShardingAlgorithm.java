package com.example.dxpzk.sharingRule;

//import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;

/**
 * @author zk
 * @since 2020-03-15
 */
//@Service
//public class HintDatabaseShardingAlgorithm implements HintShardingAlgorithm {
//
//    public HintDatabaseShardingAlgorithm() {
//    }
//
//    @Override
//    public Collection<String> doSharding(Collection<String> collection, io.shardingsphere.api.algorithm.sharding.ShardingValue shardingValue) {
//        Collection<String> result = new ArrayList<>();
////        for (String each : availableTargetNames) {
////            for (Long value : shardingValue.getValues()) {
////                if (each.endsWith(String.valueOf(value % 2))) {
//        result.add("ds1");
////                }
////            }
////        }
//        return result;
//    }
//
////    @Override
////    public Collection<String> doSharding(Collection<String> collection, io.shardingjdbc.core.api.algorithm.sharding.ShardingValue shardingValue) {
////        Collection<String> result = new ArrayList<>();
//////        for (String each : availableTargetNames) {
//////            for (Long value : shardingValue.getValues()) {
//////                if (each.endsWith(String.valueOf(value % 2))) {
////        result.add("ds1");
//////                }
//////            }
//////        }
////        return result;
////    }
//}
