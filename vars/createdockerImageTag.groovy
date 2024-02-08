def call(String serviceName, String buildDeploymentVersion, String accountNumber, String region, String envName) {

    def registryUrl = constructRegistryUrl(accountNumber, region, serviceName, envName)
    println "ECR registryUrl createdockerImageTag: '${registryUrl}'"

    // Define a closure to append the deployment version to the registry URL
    def appendbuildDeploymentVersion = { url -> "${url}:${buildDeploymentVersion}" }

    // Append the deployment version to the registry URL using the closure
    def awsEcrdockerImageTag = appendbuildDeploymentVersion(registryUrl)

    println "AWS ECR awsEcrdockerImageTag createdockerImageTag: '${awsEcrdockerImageTag}'"
    return awsEcrdockerImageTag
}

def constructRegistryUrl(String accountNumber, String region, String serviceName, String envName) {
    "${accountNumber}.dkr.ecr.${region}.amazonaws.com/${serviceName}-${envName}"
}
