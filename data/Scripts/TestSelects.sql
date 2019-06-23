SELECT CD.SeriesId,
		CD.Year,
		Y.YearId,
		CD.Period,
		P.PeriodAbbr,
		P.PeriodName,
		CD.Value
FROM tblSeries AS S 
	LEFT JOIN tblCurrentData AS CD ON
		S.SeriesId = CD.SeriesId
	LEFT JOIN tblYear AS Y ON
		CD.Year = Y.Year
	LEFT JOIN tblPeriod AS P ON
		CD.Period = P.Period	
WHERE S.AreaCode = '0' AND
	S.ItemCode = '701111' AND
CD.Year IN (2001,2002,2003,2004,2005,2006)


SELECT *
FROM tblSeries AS S 
	LEFT JOIN tblCurrentData AS CD ON
		S.SeriesId = CD.SeriesId
WHERE CD.Year IN (2001,2002,2003,2004,2005,2006)

SELECT * FROM tblCurrentData AS CD
LEFT JOIN tblSeries AS S ON
	CD.SeriesId = S.SeriesId

SELECT * 
FROM tblSeries AS S 
	LEFT JOIN tblCurrentData AS CD ON
		S.SeriesId = CD.SeriesId;