SELECT * FROM bls.tblSeries AS S
LEFT JOIN bls.tblArea AS A ON
	S.AreaCode = A.AreaCode
LEFT JOIN bls.tblItem AS I ON
	S.ItemCode = I.ItemCode
LEFT JOIN bls.tblPeriod AS P ON
	S.BeginPeriod = P.Period
LEFT JOIN bls.tblPeriod AS P2 ON
	S.EndPeriod = P2.Period
LEFT JOIN bls.tblCurrentData AS CD ON
	S.SeriesId = CD.SeriesId