fun main(args: Array<String>) {
    Config.checkFile()

    Injector.parseAndCopyCfg()
    Injector.parseAndCopyScripts()
    Injector.parseAndCopyMods()
    Injector.removeClientMods()
//    Injector.parseMods()
//    Injector.getClient()

}