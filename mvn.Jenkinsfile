#!groovy

//参数构建-选择参数
//源码所在地址
String srcUrl = "${env.srcUrl}"
//分支名
String branchName = "${env.branchName}"

pipeline {
    agent {node {label "master"}}

    stages {
        //从git仓库拉取代码
        stage("Checkout") {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'gitlab-login', url: "${srcUrl}"]]])
                }
            }
        }

        //mvn构建
        stage("Build") {
            steps {
                script {
                    mavenHome = tool 'M2'
                    sh "${mavenHome}/bin/mvn clean package -DskipTests"
                }
            }
        }
    }
}
