package socialmusic

class Track {

    String title
    String artist
    String album
    Integer totalGrade=0



    static hasMany = [grades : Grade]
    static constraints = {
        title(blank: false)
        artist(blank: false)
        album(blank: false)
    }

   public String toString(){
        title
    }
}
