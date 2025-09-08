@ECHO OFF
:: Gradle startup script for Windows

SET DIRNAME=%~dp0
IF "%DIRNAME%" == "" SET DIRNAME=.
SET APP_BASE_NAME=%~n0
SET APP_HOME=%DIRNAME%

SET DEFAULT_JVM_OPTS=

SET CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

IF NOT "%JAVA_HOME%" == "" (
    SET JAVACMD=%JAVA_HOME%\bin\java.exe
) ELSE (
    SET JAVACMD=java
)

IF NOT EXIST "%JAVACMD%" (
    ECHO ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. >&2
    EXIT /B 1
)

"%JAVACMD%" %DEFAULT_JVM_OPTS% -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*￼Enter
