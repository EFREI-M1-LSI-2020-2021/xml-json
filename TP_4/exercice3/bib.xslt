<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="bib">
        <html>
            <body>
                <h1 align="left">Domaines</h1>
                <xsl:apply-templates select="domain/title" mode="domainTitleWithA"/>
                <hr/>
                <hr/>

                <xsl:apply-templates select="domain"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="domain">
        <table border="1" width="100%">
            <tbody>
                <tr>
                    <td bgcolor="#c0c0c0" width="100%">
                        <h2><xsl:value-of select="title"/></h2>
                    </td>
                </tr>
            </tbody>
        </table>
        <xsl:apply-templates select="bib_ref"/>
    </xsl:template>

    <xsl:template match="bib_ref">
        <hr/>
        <h3>Titre : <xsl:value-of select="title"/></h3>
        Auteur(s) : <xsl:value-of select="author"/><br/>

        Année : <xsl:value-of select="year"/><br />

        Lien : <a href="#{weblink}"><xsl:value-of select="weblink"/></a><br/>
        Commentaires:
        <xsl:value-of select="bib_ref/comments"/>
    </xsl:template>

    <xsl:template match="domain/title" mode="domainTitleWithA">
        <h2><a href="#{.}"><xsl:apply-templates/></a></h2>
    </xsl:template>
</xsl:stylesheet>

