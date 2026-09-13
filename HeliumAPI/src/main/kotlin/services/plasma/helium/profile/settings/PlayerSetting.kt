package services.plasma.helium.profile.settings

enum class PlayerSetting(val displayName: String, val description: String, val states: List<String>) {
    GLOBAL_CHAT("Global Chat", "See public messages.", listOf("enabled", "disabled")),
    PRIVATE_MESSAGES("Private Messages", "Let other message you.", listOf("enabled", "disabled")),
    FRIEND_REQUESTS("Friend Requests", "Let other friend you.", listOf("enabled", "disabled")),
    MESSAGE_SOUND("Message Sound", "Play a sound when receiving a message", listOf("enabled", "disabled")),
    TIPS("Server Tips", "Receive periodic server tips and announcements", listOf("enabled", "disabled"));
}
