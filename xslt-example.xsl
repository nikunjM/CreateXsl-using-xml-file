<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml">
      <body>
	<h2>Shooping list</h2>
	<table border="1">
	  <tr bgcolor="green">
            <th>Name</th>
            <th>Description</th>
	  </tr>
	  <xsl:for-each select="//categories/category/items/product[rating/rating>='1.50']">
	    <tr>
	      <td>
		<xsl:value-of select="name"/>,
	      </td>
	      <td><xsl:value-of select="fulldescription"/></td>
	    </tr>
	  </xsl:for-each>
	</table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
