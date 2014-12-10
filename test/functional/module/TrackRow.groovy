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

        artist {
            cellText (1)
        }

        album {
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