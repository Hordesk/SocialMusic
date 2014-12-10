package pages.user

import module.TrackRow

class AllMusicPage extends LayoutPage{
    static url = "grade/likeUnlike"

    static content = {
        trackTable {
            $("div[id='tracks-list'] table", 0)
        }

        trackRows {
            trackTable.find('tbody').find('tr')
        }

        row { rowIndice ->
            module(TrackRow, trackRows[rowIndice])
        }


    }
}
