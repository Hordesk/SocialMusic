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

        trackTitle {
            cellText (0)
        }

        album {
            cellText (1)
        }

        artist {
            cellText (2)
        }

        grade {
            cellText (3)
        }

        like {
            $('td a', 0)
        }

        unlike {
            $('td a', 1)
        }
    }
}