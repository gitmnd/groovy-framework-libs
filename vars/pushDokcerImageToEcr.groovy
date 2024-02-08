def call(String accountNumber, String region, String dockerImageTag, String awsEcrdockerImageTag) {
    bat """
        echo "Logging into ECR" 
        aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${accountNumber}.dkr.ecr.${region}.amazonaws.com        

        echo "Tagging Docker image  ${dockerImageTag} with tag ${awsEcrdockerImageTag}" 
        docker tag ${dockerImageTag} ${awsEcrdockerImageTag}
        
        echo "Pushing Docker image ${awsEcrdockerImageTag}" 
        docker push ${awsEcrdockerImageTag}
    """
}