/*
 * Copyright 2017-2022 The DLedger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openmessaging.storage.dledger.store;

import io.openmessaging.storage.dledger.MemberState;
import io.openmessaging.storage.dledger.entry.DLedgerEntry;

public abstract class DLedgerStore {

    public MemberState getMemberState() {
        return null;
    }

    /**
     * 向主节点追加日志（数据）
     * @param entry
     * @return
     */
    public abstract DLedgerEntry appendAsLeader(DLedgerEntry entry);

    /**
     * 向从节点广播日志（数据）
     * @param entry
     * @param leaderTerm
     * @param leaderId
     * @return
     */
    public abstract DLedgerEntry appendAsFollower(DLedgerEntry entry, long leaderTerm, String leaderId);

    /**
     * 根据日志序列查找日志
     * @param index
     * @return
     */
    public abstract DLedgerEntry get(Long index);

    /**
     * 获取已提交日志序号
     * @return
     */
    public abstract long getCommittedIndex();

    public void updateCommittedIndex(long term, long committedIndex) {

    }

    /**
     * 获取 Leader 节点当前最大的投票轮次
     * @return
     */
    public abstract long getLedgerEndTerm();

    /**
     * 获取 Leader 节点下一条日志写入的日志序号（最新日志序号）
     * @return
     */
    public abstract long getLedgerEndIndex();

    /**
     * 获取 Leader 节点第一条消息的日志序号
     * @return
     */
    public abstract long getLedgerBeginIndex();

    /**
     * 从 Leader 节点获取最新日志序号和投票轮次 更新本地状态缓存
     */
    protected void updateLedgerEndIndexAndTerm() {
        if (getMemberState() != null) {
            getMemberState().updateLedgerIndexAndTerm(getLedgerEndIndex(), getLedgerEndTerm());
        }
    }

    /**
     * 刷盘
     */
    public void flush() {

    }

    /**
     * 从 entry 开始截断，删除之后的所有日志
     * @param entry
     * @param leaderTerm
     * @param leaderId
     * @return
     */
    public long truncate(DLedgerEntry entry, long leaderTerm, String leaderId) {
        return -1;
    }

    /**
     * 启动存储管理器
     */
    public void startup() {

    }

    /**
     * 关闭存储管理器
     */
    public void shutdown() {

    }
}
