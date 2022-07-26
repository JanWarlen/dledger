## 入口关键类
### 节点选举
#### 启动选举维护线程入口
io.openmessaging.storage.dledger.DLedgerLeaderElector.startup
#### 内部状态自检入口
io.openmessaging.storage.dledger.DLedgerLeaderElector.StateMaintainer.doWork
#### 节点投票发起入口
io.openmessaging.storage.dledger.DLedgerLeaderElector.voteForQuorumResponses
#### 节点投票处理入口
io.openmessaging.storage.dledger.DLedgerLeaderElector.handleVote
### 节点接收请求集中转发入口
io.openmessaging.storage.dledger.DLedgerRpcNettyService.processRequest
### 日志存储
#### 客户端日志写入请求
io.openmessaging.storage.dledger.DLedgerServer.handleAppend
#### 日志转发与处理核心类
io.openmessaging.storage.dledger.DLedgerEntryPusher.startup
#### 日志转发入口
io.openmessaging.storage.dledger.DLedgerEntryPusher.EntryDispatcher.doWork
#### 从节点接收日志处理入口
io.openmessaging.storage.dledger.DLedgerServer.handlePush
#### 日志比较
##### 主节点发起比较入口
io.openmessaging.storage.dledger.DLedgerEntryPusher.EntryDispatcher.doCompare
##### 从节点接收比较请求，处理入口
io.openmessaging.storage.dledger.DLedgerEntryPusher.EntryHandler.handleDoCompare




## Introduction
[![Build Status](https://www.travis-ci.org/openmessaging/dledger.svg?branch=master)](https://www.travis-ci.org/search/dledger) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.openmessaging.storage/dledger/badge.svg)](http://search.maven.org/#search%7Cga%7C1%7Copenmessaging-storage-dledger)  [![Coverage Status](https://coveralls.io/repos/github/openmessaging/openmessaging-storage-dledger/badge.svg?branch=master)](https://coveralls.io/github/openmessaging/openmessaging-storage-dledger?branch=master) [![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

A raft-based java library for building high-available, high-durable, strong-consistent commitlog, which could act as the persistent layer for distributed storage system, i.e. messaging, streaming, kv, db, etc.

Dledger has added many new features that are not described in the [original paper](https://raft.github.io/raft.pdf). It has been proven to be a true production ready product. 


## Features

* Leader election
* Preferred leader election
* [Pre-vote protocol](https://web.stanford.edu/~ouster/cgi-bin/papers/OngaroPhD.pdf)
* High performance, high reliable storage support
* Parallel log replication between leader and followers
* Asynchronous replication
* High tolerance of symmetric network partition
* High tolerance of asymmetric network partition
* [Jepsen verification with fault injection](https://github.com/openmessaging/openmessaging-dledger-jepsen)

### New features waiting to be added ###
* State machine
* Snapshot
* Multi-Raft 
* Dynamic membership & configuration change
* SSL/TLS support

## Quick Start


### Prerequisite

* 64bit JDK 1.8+

* Maven 3.2.x

### How to Build

```
mvn clean install -DskipTests
```

### Run Command Line

 * Get Command Usage
```
java -jar target/DLedger.jar

```

* Start DLedger Server
```
nohup java -jar target/DLedger.jar server &

```

* Append Data to DLedger
```
java -jar target/DLedger.jar append -d "Hello World"

```

* Get Data from DLedger
```

java -jar target/DLedger.jar get -i 0

```

## Contributing
We always welcome new contributions, whether for trivial cleanups, big new features. We are always interested in adding new contributors. What we look for are series of contributions, good taste and ongoing interest in the project. If you are interested in becoming a committer, please let one of the existing committers know and they can help you walk through the process.

## License
[Apache License, Version 2.0](https://github.com/openmessaging/openmessaging-storage-dledger/blob/master/LICENSE) Copyright (C) Apache Software Foundation
 
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fopenmessaging%2Fopenmessaging-storage-dledger.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fopenmessaging%2Fopenmessaging-storage-dledger?ref=badge_large)












