package pages.user

class AddTrackPage extends LayoutPage{
    static url = "/SocialMusic/track/create"

    static at = {
        title ==~ /Create Track/
    }

    static content = {
        trackTitle { $('input', id: "title") }
        trackArtist { $('input', id: "artist") }
        trackAlbum { $('input', id: "album") }

        createButton(to: CollectionPage) { $('input', id: 'create') }
    }
}
