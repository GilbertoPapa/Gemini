package gemini.data.service

import de.jensklingenberg.ktorfit.http.Body
import gemini.data.model.GeminiResponse
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Query
import gemini.data.model.GeminiRequest

interface GeminiService {

    @Headers("Content-Type: application/json")
    @POST("v1beta/models/gemini-pro:generateContent")
    suspend fun postPromptGemini(@Body body : GeminiRequest, @Query("key") key : String): GeminiResponse
}