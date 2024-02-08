def call(String environmentType,timeoutValue, String timeoutUnit) {
       timeout(time: timeoutValue, unit: timeoutUnit) {
            def userFeedbackInput = processInput(environmentType, timeoutValue, timeoutUnit)
            if (userFeedbackInput != environmentType) {
                currentBuild.result = 'ABORTED'
                error("Stopping, deploying to ${environmentType} was aborted")
            }
    }

}

def processInput(String environmentType,timeoutValue, String timeoutUnit) {
    def userFeedbackInput = input(
            id: 'approve',
            message: "Deploy ${environmentType}?\nType ${environmentType} to proceed",
            Approve: environmentType,
            parameters: [
                    string(
                            defaultValue: 'ABORT',
                            description: "Are you sure to Approve deployment to ${environmentType}?",
                            name: 'Answer:')
            ])

}