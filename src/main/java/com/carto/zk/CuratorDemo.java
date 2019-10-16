package com.carto.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;


/**
 * 集群角色： leader、follower、observer
 *
 * leader:事务请求的唯一调度和处理者，保证集群事务处理的顺序性
 *
 * follower:参与leader投票
 *
 * observer：不投票；增加非事务处理能力。 仍然会涉及数据同步，但是不投票，可以减少一部分消耗。
 *
 * 一般由2n+1台服务器组成
 *
 */
public class CuratorDemo {

    public final static String CON = "";

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().build();

        LeaderSelector leaderSelector = new LeaderSelector(curatorFramework, "master", new LeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println("获取leader成功");
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {

            }
        });

        leaderSelector.autoRequeue();
        leaderSelector.start();
    }
}
