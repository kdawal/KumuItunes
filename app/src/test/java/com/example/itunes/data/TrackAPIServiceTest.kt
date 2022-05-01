package com.example.itunes.data

import com.example.itunes.data.api.TrackAPIService
import com.google.common.truth.Truth.assertThat
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Mocking api request
 *
 * Test function to test if the api service is working as intended
 */
@RunWith(JUnit4::class)
class TrackAPIServiceTest {
 private lateinit var service: TrackAPIService
 private lateinit var server: MockWebServer
 private lateinit var moshi: Moshi

 @Before
 fun setUp() {
  server = MockWebServer()
  moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
  service = Retrofit.Builder()
   .baseUrl(server.url(""))
   .addConverterFactory(ScalarsConverterFactory.create())
   .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
   .build()
   .create(TrackAPIService::class.java)
 }

 @Test
 fun getTracks_sendRequest_receivedExpected() {
  enqueueMockResponse()
  runBlocking {
   val response = service.getTracks()
   assertThat(response).isNotNull()
  }
 }

 private fun enqueueMockResponse(){
  val inputStream = javaClass.classLoader!!.getResourceAsStream("TracksResponse.json")
  val source = inputStream.source().buffer()
  val mockResponse = MockResponse()
  mockResponse.setBody(source.readString(Charsets.UTF_8))
  server.enqueue(mockResponse)
 }
}