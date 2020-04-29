#!groovy

//加载共享代码库
@Library('jenkins-library') _

def tools = new org.devops.tools()

String workspace = "/opt/jenkins/workspace"

pipeline {
    agent any

    options {
        timestamps() //日志会有时间
        skipDefaultCheckout() //跳过从源代码控制中检出代码的默认情况
        disableConcurrentBuilds() //禁止并行
        timeout(time: 1, unit: "HOURS") //流水线超时设置1h
    }

    stages {
        //下载代码
        stage("GetCode") {
            //步骤
            steps {
                timeout(time: 5, unit: "MINUTES") {
                    script {
                        tools.PrintColorMessage("获取代码", "blue")
                    }
                }
            }
        }

        //构建
        stage("Build") {
            //步骤
            steps {
                timeout(time: 20, unit: "MINUTES") {
                    script {
                        tools.PrintColorMessage("应用打包", "green")
                    }
                }
            }
        }

        //代码扫描
        stage("CodeScan") {
            //步骤
            steps {
                timeout(time: 30, unit: "MINUTES") {
                    script {
                        println("代码扫描")
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                println("always")
            }
        }

        success {
            script {
                currentBuild.description = "构建成功"
            }
        }

        failure {
            script {
                currentBuild.description = "构建失败"
            }
        }

        aborted {
            script {
                currentBuild.description = "构建取消"
            }
        }
    }
}
