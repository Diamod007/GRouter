package my.itgungnir.grouter.api.interceptor

import android.content.Context
import androidx.fragment.app.Fragment
import my.itgungnir.grouter.api.dto.RouterResponse

/**
 * VerifyInterceptor
 *
 * 验证路由的发出方是否合法
 */
class VerifyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): RouterResponse {

        val request = chain.request()

        return when (request.safeContext()) {
            is Context, is Fragment -> chain.proceed(request)
            else -> throw IllegalArgumentException("Unsupported context type.")
        }
    }
}