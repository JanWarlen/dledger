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

package io.openmessaging.storage.dledger.protocol;

public class RequestOrResponse {

    /**
     * Raft 复制组所属组名
     */
    protected String group;
    /**
     * 请求目标节点的id
     */
    protected String remoteId;
    /**
     * 发起请求的节点ID
     */
    protected String localId;
    /**
     * 返回相应码
     */
    protected int code = DLedgerResponseCode.SUCCESS.getCode();

    /**
     * 集群中 Leader ID
     */
    protected String leaderId = null;
    /**
     * 集群当前选举轮次
     */
    protected long term = -1;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RequestOrResponse code(int code) {
        this.code = code;
        return this;
    }

    public void setIds(String localId, String remoteId, String leaderId) {
        this.localId = localId;
        this.remoteId = remoteId;
        this.leaderId = leaderId;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public long getTerm() {
        return term;
    }

    public void setTerm(long term) {
        this.term = term;
    }

    public RequestOrResponse copyBaseInfo(RequestOrResponse other) {
        this.group = other.group;
        this.term = other.term;
        this.code = other.code;
        this.localId = other.localId;
        this.remoteId = other.remoteId;
        this.leaderId = other.leaderId;
        return this;
    }

    public String baseInfo() {
        return String.format("info[group=%s,term=%d,code=%d,local=%s,remote=%s,leader=%s]", group, term, code, localId, remoteId, leaderId);
    }

}
