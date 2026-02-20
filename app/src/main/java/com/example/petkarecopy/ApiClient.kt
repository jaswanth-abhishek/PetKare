package com.example.petkarecopy

import retrofit2.Response
import retrofit2.http.*

data class SignupRequest(val email: String, val password: String, val displayName: String)
data class LoginRequest(val email: String, val password: String)
data class ProfileUpdateRequest(val displayName: String)
data class PasswordChangeRequest(val newPassword: String)
data class ForgotPasswordRequest(val email: String)
data class AuthResponse(val auth: AuthData, val message: String?)
data class AuthData(val idToken: String)
data class UserProfile(val uid: String, val email: String, val displayName: String?)

interface ApiService {
    @POST("auth/signup")
    suspend fun signup(@Body request: SignupRequest): Response<Void>
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>
    @GET("users/me")
    suspend fun getProfile(@Header("Authorization") token: String): Response<UserProfile>
    @PUT("users/me")
    suspend fun updateProfile(
        @Header("Authorization") token: String,
        @Body request: ProfileUpdateRequest
    ): Response<Void>
    @POST("users/me/password")
    suspend fun changePassword(
        @Header("Authorization") token: String,
        @Body request: PasswordChangeRequest
    ): Response<Void>
    @POST("auth/forgot-password")
    suspend fun forgotPassword(@Body request: ForgotPasswordRequest): Response<Void>
    @POST("auth/logout")
    suspend fun logout(@Header("Authorization") token: String): Response<Void>
}

// --- 3. Retrofit Singleton  ---
object RetrofitClient {
    private const val BASE_URL = "https://YOUR_API_BASE_URL/"

    val instance: ApiService by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
