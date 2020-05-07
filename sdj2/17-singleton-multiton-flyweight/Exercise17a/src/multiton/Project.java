package multiton;

public class Project
{
  private String name;
  private String language;
  private ProjectGlossary glossary;

  public Project(String name, String language)
  {
    this.language = language;
    this.name = name;
    this.glossary = ProjectGlossary.getInstance(language);
  }

  public String getName()
  {
    return name;
  }

  public ProjectGlossary getGlossary()
  {
    return glossary;
  }

  public String getDefinition(String phrase)
  {
    return glossary.getDefinition(phrase);
  }

  public void addGlossaryItem(String phrase, String definition)
  {
    glossary.addItem(phrase, definition);
  }

  public void removeGlossaryItem(String phrase)
  {
    glossary.removeItem(phrase);
  }

  @Override public String toString()
  {
    String s = "Project: " + name;
    if (glossary.size() > 0)
    {
      s += "\n" + glossary;
    }
    else
    {
      s += " [No glossary]";
    }
    return s;
  }
}