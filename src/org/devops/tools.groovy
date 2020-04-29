package org.devops

//格式化带颜色输出
def PrintColorMessage(value,color){
    colors = ['red'   : "\033[40;31m >>>>>>>>>>>${value}<<<<<<<<<<< \033[0m",
              'blue'  : "\033[47;34m ${value} \033[0m",
              'green' : "[1;32m>>>>>>>>>>${value}>>>>>>>>>>[m"
            ]
    ansiColor('xterm') {
        println(colors[color])
    }
}
