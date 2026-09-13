package services.plasma.helium.profile

enum class PlayerStatus(
    val selfDisplay: String,
    val publicDisplay: String,
    private val blocksPrivateMessages: Boolean
) {
    ONLINE("&aOnline", "&aOnline", false),
    AWAY("&eAway", "&eAway", false),
    DO_NOT_DISTURB("&cDo Not Disturb", "&cDo Not Disturb", true),
    APPEARING_OFFLINE("&7Appearing Offline", "&cOffline", true);

    fun blocksPrivateMessages(): Boolean = blocksPrivateMessages

    fun isVisibleAsOffline(): Boolean = this == APPEARING_OFFLINE

    fun getCommandName(): String = when (this) {
        AWAY -> "away"
        DO_NOT_DISTURB -> "dnd"
        APPEARING_OFFLINE -> "offline"
        ONLINE -> "online"
    }

    companion object {
        @JvmStatic
        fun fromInput(input: String?): PlayerStatus? {
            if (input == null || input.trim().isEmpty()) {
                return null
            }

            return when (input.trim().lowercase().replace("_", "").replace("-", "").replace(" ", "")) {
                "online" -> ONLINE
                "away", "idle", "afk" -> AWAY
                "dnd", "donotdisturb" -> DO_NOT_DISTURB
                "offline", "appearingoffline", "appearoffline", "hidden", "invisible" -> APPEARING_OFFLINE
                else -> null
            }
        }

        @JvmStatic
        fun fromStorage(input: String?): PlayerStatus {
            if (input == null || input.trim().isEmpty()) {
                return ONLINE
            }

            return values().firstOrNull { it.name.equals(input, ignoreCase = true) } ?: ONLINE
        }
    }
}
