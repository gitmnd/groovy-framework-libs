def call(String serviceName, String version, String dockerFilePath) {

    def dockerImageTag = "${serviceName}:${version}".toString()

    println "version '${version}'"
    println "Building Docker image '${dockerImageTag}'"
    println "dockerFilePath '${dockerFilePath}'"

    def command = """
    docker image build ^
            --pull ^
            --build-arg version=${version} ^
            --tag ${dockerImageTag} ^
             ${dockerFilePath} 
    """
    def process = "cmd /c ${command}".execute()
    println "Executing Docker Image Build.."
    def outputStream = new StringBuffer();
    def errorStream = new StringBuffer();

    // Read output and error streams asynchronously
    process.consumeProcessOutput(outputStream, errorStream)

    // Wait for the process to finish
    process.waitFor()

    // Print output and error streams
    println "Output buildDockerImage: ${outputStream}"
    println "Error buildDockerImage: ${errorStream}"

    return dockerImageTag
}