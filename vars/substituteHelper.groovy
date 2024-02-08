def call(String location, HashMap<String, String> argsMap, String targetLocationFile) {
    try {
        def text = readFile file: location
        argsMap.each { entry ->
            text = text.replaceAll("\\\$\\{${entry.key}\\}", entry.value)
        }
        println "Generated new file -> ${targetLocationFile} with : ${text}"
        writeFile file: targetLocationFile, text: text
    }
    catch (Exception e) {
        println "An error occurred substituteHelper: ${e}"
        println "An error occurred substituteHelper: ${e.message}"
    }
}
