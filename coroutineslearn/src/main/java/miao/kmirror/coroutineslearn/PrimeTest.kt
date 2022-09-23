package miao.kmirror.coroutineslearn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    // 此时的 cur 是从 2 开始的自然数
    var cur = numbersFrom(2)
    repeat(10) {
        // 第一次 receive prime = 2
        val prime = cur.receive()
        // 第一次输出 2
        println(prime)
        // 第一次 prime = 2 传入 filter
        cur = filter(cur, prime)
    }
    coroutineContext.cancelChildren() // 取消所有的子协程, 让 main 函数结束

}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) send(x++) // 从 start 开始递增的无限整数流
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    // 第一次进入：numbers 应该是从 2 开始的自然数，
    for (i in numbers) {
        if (i % prime != 0) {
            println("prime = $prime")
            // 这里是过滤出不能被2整除的数 也就是 3，5，7.。。。
            send(i)
        }
    }
}