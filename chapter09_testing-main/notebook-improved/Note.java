
public class Note
{
    String title, text;

    public Note(String title, String text){
        this.title = title == null ? "New Note" : title; 
        this.text =  text == null ? "" : text;
    }

    @Override
    public String toString(){
        return "# "+title+"\n"+text+"\n";
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Note))
            return false;
        Note otherNote = (Note)other;
        return this.toString().equals(otherNote.toString());
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }

    public String getTitle(){return title;}

    public String getText(){return text;}

    public void setTitle(String title){this.title = title;};

    public void setText(String text){this.text = text;};

}
