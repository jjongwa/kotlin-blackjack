package blackjack.infrastructure

import blackjack.adapter.BlackjackInputAdapter
import blackjack.domain.HitStayChoice
import blackjack.domain.PlayerName
import blackjack.view.InputView

class ConsoleBackJackInputAdapter(private val inputView: InputView) : BlackjackInputAdapter {
    override fun fetchPlayerNames(): List<PlayerName> {
        val playerInput = inputView.inputPlayerNames()
        return playerInput.split(",")
            .map { PlayerName(it.trim()) }
    }

    override fun fetchMoreCard(playerName: String): HitStayChoice {
        val moreCardInput = inputView.inputMoreCard(playerName)
        return HitStayChoice.from(moreCardInput)
    }
}