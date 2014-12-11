package pages.user

import module.TrackRow
import socialmusic.Track

class CollectionPage extends LayoutPage {
    static url = "user/bibliotheque"

    static at = {
        title ==~ /Bibliothèque/
    }

    static content = {
        trackTable {
            $("div[id='collection-list'] table", 0)
        }

        trackRows {
            trackTable.find('tbody').find('tr')
        }

        row { rowIndice ->
            module(TrackRow, trackRows[rowIndice])
        }
    }

    def containsTrack(track) {
        for (int i = 0; i < trackRows.size(); i++) {
            def t = row(i)

            if (t.artist == track.artist &&
                    t.album == track.album &&
                    t.trackTitle == track.title) {
                return true
            }
        }
        return false
    }
}
