package module

import geb.Module

class TrackRow extends Module {
    static content = {
        cell { column ->
            $ ('td', column)
        }

        cellText { column ->
            cell (column).text ()
        }

        artist {
            cellText (0)
        }

        album {
            cellText (1)
        }

        trackTitle {
            cellText (2)
        }
    }
}