package app.coinverse.feed.state

import app.coinverse.feed.Content
import app.coinverse.feed.state.FeedViewIntentType.LabelContent
import app.coinverse.feed.state.FeedViewIntentType.SelectContent
import app.coinverse.feed.state.FeedViewIntentType.SwipeContent
import app.coinverse.feed.state.FeedViewIntentType.SwipeToRefresh
import app.coinverse.utils.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
interface FeedView {
    /**
     * Intent to load the current feed state
     *
     * @return A flow that inits the current feed state
     */
    fun initState(): Flow<Boolean>

    /**
     * Intent to load the feed from the network
     *
     * @return A flow that inits loading the feed state from the network
     */
    fun loadFromNetwork(): Flow<Boolean>

    /**
     * Intent to update the feed from a SwipeToRefresh
     *
     * @return A flow that inits loading the feed state from the network
     */
    fun swipeToRefresh(): Flow<SwipeToRefresh>

    /**
     * Intent to select content from the feed
     *
     * @return A flow that emits the content to select from the feed
     */
    fun selectContent(): Flow<Event<SelectContent?>>

    /**
     * Intent to drag or swipe content in the feed in order to label it
     *
     * @return A flow that inits the content swipe navigation
     */
    fun swipeContent(): Flow<SwipeContent>

    /**
     * Intent to label content in the feed as a result of swiping an item
     *
     * @return A flow that inits the content labeling
     */
    fun labelContent(): Flow<LabelContent>

    /**
     * Intent to share content from the feed
     *
     * @return A flow that emits the content to share from the feed
     */
    fun shareContent(): Flow<Content>

    /**
     * Intent to open content from the feed
     *
     * @return A flow that emits the content to open from the feed
     */
    fun openContentSource(): Flow<String>

    /**
     * Intent to update feed ads
     *
     * @return A flow that inits update the feed's ads
     */
    fun updateAds(): Flow<Boolean>

    /**
     * Renders the feed view state
     *
     * @param state The current view state display
     */
    fun render(state: FeedViewState)
}
