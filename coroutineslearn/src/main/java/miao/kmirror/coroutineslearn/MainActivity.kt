package miao.kmirror.coroutineslearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    val TAG = "miao"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
//            val flow = (1..3).asFlow().flowOn(Dispatchers.Main)
//            flow.collect {
//                Log.i("miao", "onCreate: $it")
//            }

//            flow.filter {
//                Log.e("miao", "$it filter")
//                it % 2 != 0
//            }.map {
//                Log.e("miao", "$it map")
//                "${it * it} money"
//            }.collect {
//                Log.e("miao", "i get $it")
//            }

//            lifecycleScope.launch {
//                val f = flow {
//                    for (i in 1..3) {
//                        delay(500)
//                        Log.i(TAG, "emit $i ")
//                        emit(i)
//                    }
//                }
//
//                withTimeoutOrNull(1600) {
//                    f.collect {
//                        delay(500)
//                        Log.i(TAG, "collect $it")
//                    }
//                }
//                Log.i(TAG, "cancel")
//            }


            val time = measureTimeMillis {
                simple()
                    .collect {
                        delay(300)
                        println("collect = "+System.currentTimeMillis())
                        println(it)
                    }
            }
            println("Collected in $time ms")


        }
    }

    private fun simple() = flow {

        // 如何理解 buffer
        for (i in 1..3) {
            if(i == 2){
                delay(400)
            }else{
                delay(100)
            }
//            delay(100) // 假设这里的异步操作需要等待 100 ms
            println("emit = "+System.currentTimeMillis())
            emit(i)
        }
        /*
2022-09-14 08:53:45.079 13116-13116/miao.kmirror.coroutineslearn I/System.out: emit = 1663116825079
2022-09-14 08:53:45.381 13116-13116/miao.kmirror.coroutineslearn I/System.out: collect = 1663116825381
2022-09-14 08:53:45.381 13116-13116/miao.kmirror.coroutineslearn I/System.out: 1
2022-09-14 08:53:45.482 13116-13116/miao.kmirror.coroutineslearn I/System.out: emit = 1663116825481
2022-09-14 08:53:45.583 13116-13116/miao.kmirror.coroutineslearn I/System.out: emit = 1663116825583
2022-09-14 08:53:45.783 13116-13116/miao.kmirror.coroutineslearn I/System.out: collect = 1663116825783
2022-09-14 08:53:45.783 13116-13116/miao.kmirror.coroutineslearn I/System.out: 2
2022-09-14 08:53:46.084 13116-13116/miao.kmirror.coroutineslearn I/System.out: collect = 1663116826084
2022-09-14 08:53:46.084 13116-13116/miao.kmirror.coroutineslearn I/System.out: 3
2022-09-14 08:53:46.087 13116-13116/miao.kmirror.coroutineslearn I/System.out: Collected in 1121 ms
2022-09-14 08:54:06.432 13116-13129/miao.kmirror.coroutineslearn W/System: A resource failed to call close.
2022-09-14 08:56:00.466 13116-13116/miao.kmirror.coroutineslearn W/coroutineslearn: type=1400 audit(0.0:4288): avc: granted { execute } for path="/data/data/miao.kmirror.coroutineslearn/code_cache/startup_agents/4ba71210-agent.so" dev="dm-4" ino=87317 scontext=u:r:untrusted_app:s0:c213,c256,c512,c768 tcontext=u:object_r:app_data_file:s0:c213,c256,c512,c768 tclass=file app=miao.kmirror.coroutineslearn
2022-09-14 08:56:00.473 13116-13116/miao.kmirror.coroutineslearn V/studio.deploy: Prior agent invocations in this VM: 0
*/
    }
}