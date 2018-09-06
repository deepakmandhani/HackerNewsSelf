package gg.krish.retrofittutorial;

import java.util.List;

/**
 * Created by deepak.mandhani on 18/01/18.
 */

public class NewsResponse
{
    private List<Hits> hits;

    private String page;

    private String query;

    private String processingTimeMS;

    private String params;

    private String exhaustiveNbHits;

    private String nbHits;

    private String hitsPerPage;

    private String nbPages;

    public List<Hits> getHits ()
    {
        return hits;
    }

    public void setHits (List<Hits> hits)
    {
        this.hits = hits;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getQuery ()
    {
        return query;
    }

    public void setQuery (String query)
    {
        this.query = query;
    }

    public String getProcessingTimeMS ()
    {
        return processingTimeMS;
    }

    public void setProcessingTimeMS (String processingTimeMS)
    {
        this.processingTimeMS = processingTimeMS;
    }

    public String getParams ()
    {
        return params;
    }

    public void setParams (String params)
    {
        this.params = params;
    }

    public String getExhaustiveNbHits ()
    {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits (String exhaustiveNbHits)
    {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public String getNbHits ()
    {
        return nbHits;
    }

    public void setNbHits (String nbHits)
    {
        this.nbHits = nbHits;
    }

    public String getHitsPerPage ()
    {
        return hitsPerPage;
    }

    public void setHitsPerPage (String hitsPerPage)
    {
        this.hitsPerPage = hitsPerPage;
    }

    public String getNbPages ()
    {
        return nbPages;
    }

    public void setNbPages (String nbPages)
    {
        this.nbPages = nbPages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hits = "+hits+", page = "+page+", query = "+query+", processingTimeMS = "+processingTimeMS+", params = "+params+", exhaustiveNbHits = "+exhaustiveNbHits+", nbHits = "+nbHits+", hitsPerPage = "+hitsPerPage+", nbPages = "+nbPages+"]";
    }
}
