class SetEnv {
    String product
    String name
    String accountNumber
    String region

    SetEnv(Map config) {
        this.product = config.product
        this.name = config.name
        this.accountNumber = config.accountNumber
        this.region = config.region
    }

    private static final SetEnv NON_PROD = new SetEnv(product: "cicd-kubernetes-image-version-jenkins", name: "nonprod", accountNumber: "<AWS_ACC_NO>", region: "us-east-1")
    private static final SetEnv PROD = new SetEnv(product: "cicd-kubernetes-image-version-jenkins", name: "prod", accountNumber: "<AWS_ACC_NO>", region: "us-east-1")

    // Define a map to store environment configurations
    static final SET_ENV = [
            (NON_PROD.name): NON_PROD,
            (PROD.name): PROD
    ]
}


