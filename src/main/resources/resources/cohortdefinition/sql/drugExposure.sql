select C.person_id, C.drug_exposure_start_date as start_date, C.drug_exposure_end_date as end_date
from 
(
  select de.*, ROW_NUMBER() over (PARTITION BY de.person_id ORDER BY de.drug_exposure_start_date) as ordinal
  FROM @CDM_schema.DRUG_EXPOSURE de
@codesetClause
) C
JOIN @CDM_schema.PERSON P on C.person_id = P.person_id
JOIN @CDM_schema.VISIT_OCCURRENCE V on C.visit_occurrence_id = V.visit_occurrence_id and C.person_id = V.person_id
LEFT JOIN @CDM_schema.PROVIDER PR on C.provider_id = PR.provider_id
@whereClause