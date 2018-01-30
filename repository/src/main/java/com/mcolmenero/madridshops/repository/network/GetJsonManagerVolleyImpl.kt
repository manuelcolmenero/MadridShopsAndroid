package com.mcolmenero.madridshops.repository.network

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.mcolmenero.madridshops.repository.ErrorCompletion
import com.mcolmenero.madridshops.repository.SuccessCompletion
import java.lang.ref.WeakReference

class GetJsonManagerVolleyImpl(context: Context): GetJsonManager {

    /**
     * Se crea un contexto con referencia debil para poder eliminar dicha relación
     * y que no se embucle y nunca se pueda cerrar la conexión
     */
    var weakContext:  WeakReference<Context> = WeakReference(context)
    var requestQueue: RequestQueue? = null

    override fun execute(url: String, success: SuccessCompletion<String>, error: ErrorCompletion) {

        // create request (success, failure)
        // Pide a donde se conecta (URL) y que acciones realiza
        val request = StringRequest(
                url,
                /**
                 * Comunica que se ha completado correctamente
                 */
                Response.Listener {
                    Log.d("JSON", it)
                    success.successCompletion(it)
                },
                /**
                 * Comunica que se ha completado incorrectamente
                 */
                Response.ErrorListener {
                    error.errorCompletion(it.localizedMessage)
                })

        // add request to queue
        requestQueue().add(request)

    }

    /**
     * Lazy request para solicitar una cola de petición
     */
    fun requestQueue(): RequestQueue {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(weakContext.get())
            return requestQueue !!
        }

        return requestQueue !!
    }

}