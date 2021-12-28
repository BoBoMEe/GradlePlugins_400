package com.bobomee.publish

class PublishConfig {
    String groupId = ""
    String artifactId = ""
    String version = ""

    String pomName = ""
    String pomDescription = ""
    String pomUrl = ""

    Boolean local = true // 是否本地
    Boolean snapshot = true // 是否是快照

    // 本地仓库地址，如 ../../repo，不配置默认为 USER_HOME/.m2/repository
    String repoLocal = ""

    // local 为 false 时生效
    String repoSnapshot = ""
    // snapshot 为 false 时生效
    String repoRelease = ""
    String repoName = ""
    String repoPassword = ""
}
