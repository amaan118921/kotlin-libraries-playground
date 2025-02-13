plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
    id("com.apollographql.apollo")

    /** kotlin("kapt") **/
    // NOTE: IF if your library uses kapt
    // NOTE: THEN it belongs in "kotlin-codegen", not here!
}

sqldelight {
    database("AppDatabase") {
        packageName = "playground.sqldelight"
    }
    linkSqlite = false
}

apollo {
    generateKotlinModels.set(true)
}

// File build.gradle.kts
dependencies {
    implementation(project(":kotlin-codegen"))
    // Keep dependencies sorted to minimize merge conflicts on pull-requests!
    implementation("app.cash.barber:barber:_")
    implementation ("com.github.ajalt:mordant:_")
    implementation("com.beust:klaxon:_")
    implementation("com.github.ajalt.clikt:clikt:_")
    implementation("com.github.kittinunf.fuel:fuel:_")
    implementation("com.github.kittinunf.fuel:fuel-kotlinx-serialization:_")
    implementation("com.h2database:h2:_")
    implementation("com.rabbitmq:amqp-client:_")
    implementation("com.sksamuel.hoplite:hoplite-core:_")
    implementation("com.sksamuel.hoplite:hoplite-hocon:_")
    implementation("com.sksamuel.hoplite:hoplite-yaml:_")
    implementation(Square.sqlDelight.drivers.jdbcSqlite)
    implementation("com.tinder.statemachine:statemachine:_")
    implementation("com.uchuhimo:konf:_")
    implementation("io.github.lucapiccinelli:konad:_")
    implementation("io.github.serpro69:kotlin-faker:_")
    implementation("io.konform:konform:_")
    implementation("io.reactivex.rxjava3:rxjava:_")
    implementation("it.skrape:skrapeit-core:_")
    implementation("it.skrape:skrapeit-http-fetcher:_")
    implementation("org.apache.velocity.tools:velocity-tools-generic:_")
    implementation("org.apache.velocity:velocity-engine-core:_")
    implementation("org.jdbi:jdbi3-core:_")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:_")
    implementation("org.jetbrains.exposed:exposed-core:_")
    implementation("org.jetbrains.exposed:exposed-dao:_")
    implementation("org.jetbrains.exposed:exposed-java-time:_")
    implementation("org.jetbrains.exposed:exposed-jdbc:_")
    implementation("org.jetbrains.kotlin:kotlin-reflect:_")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:_")
    implementation("org.jetbrains:markdown-jvm:_")
    implementation("org.kodein.db:kodein-db-jvm:_")
    implementation("org.kodein.db:kodein-db-serializer-kotlinx:_")
    implementation( "org.kodein.db:kodein-leveldb-jni-jvm-linux:_")
    implementation( "org.kodein.db:kodein-leveldb-jni-jvm-macos:_")
    implementation( "org.kodein.db:kodein-leveldb-jni-jvm-windows:_")
    implementation("org.kodein.di:kodein-di:_")
    implementation("org.koin:koin-core:_")
    implementation("org.nield:kotlin-statistics:_")
    implementation("org.slf4j:slf4j-simple:_")
    // Keep dependencies sorted to minimize merge conflicts on pull-requests!
    implementation(JakeWharton.picnic)
    implementation(JakeWharton.retrofit2.converter.kotlinxSerialization)
    implementation(Kotlin.stdlib.jdk8)
    implementation(KotlinX.collections.immutable)
    implementation(KotlinX.coroutines.core)
    implementation(KotlinX.html.jvm)
    implementation(KotlinX.serialization.core)
    implementation(KotlinX.serialization.properties)
    implementation(Ktor.client.core)
    implementation(Ktor.client.okHttp)
    implementation(Ktor.client.serialization)
    implementation(Square.kotlinPoet)
    implementation(Square.okHttp3.loggingInterceptor)
    implementation(Square.okHttp3.mockWebServer)
    implementation(Square.okHttp3.okHttp)
    implementation(Square.retrofit2.converter.moshi)
    implementation(Square.retrofit2.retrofit)
    implementation("com.apollographql.apollo:apollo-coroutines-support:_")
    implementation("com.apollographql.apollo:apollo-runtime:_")
    implementation(KotlinX.serialization.json)
    implementation(KotlinX.serialization.properties)

    // Keep dependencies sorted to minimize merge conflicts on pull-requests!
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("run", JavaExec::class.java) {
    this.main = "playground._mainKt"
}

tasks.withType<JavaExec> {
    classpath = sourceSets["main"].runtimeClasspath
}
