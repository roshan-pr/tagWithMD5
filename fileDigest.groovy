def md5sum(file) {
    def fileContents = readFile(file).replaceAll("[\n\r]", "")
    java.security.MessageDigest.getInstance("MD5").digest(fileContents.getBytes()).encodeHex().toString()
}

return this