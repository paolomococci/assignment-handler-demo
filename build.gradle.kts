buildscript {
	ext {
		kotlinVersion = '1.3.31'
		springBootVersion = '2.1.5.RELEASE'
	}
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath "org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}"
		classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
		classpath "org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}"
	}
}

apply plugin: 'kotlin'
apply plugin: 'kotlin-spring'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'local.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-actuator'
	implementation 'org.springframework.boot:spring-boot-starter-data-neo4j'
	implementation 'org.neo4j:neo4j-ogm-embedded-driver:3.2.0-alpha05'
	implementation 'org.neo4j:neo4j:3.5.6'
	implementation 'org.springframework.boot:spring-boot-starter-data-rest'
	implementation 'org.springframework.boot:spring-boot-starter-hateoas'
	implementation 'com.voodoodyne.jackson.jsog:jackson-jsog:1.1.1'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'com.fasterxml.jackson.module:jackson-module-kotlin'
	implementation 'org.springframework.data:spring-data-rest-hal-browser'
	implementation 'org.jetbrains.kotlin:kotlin-stdlib-jdk8'
	implementation 'org.jetbrains.kotlin:kotlin-reflect'
	runtimeOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

compileKotlin {
	kotlinOptions {
		freeCompilerArgs = ['-Xjsr305=strict']
		jvmTarget = '1.8'
	}
}

compileTestKotlin {
	kotlinOptions {
		freeCompilerArgs = ['-Xjsr305=strict']
		jvmTarget = '1.8'
	}
}
