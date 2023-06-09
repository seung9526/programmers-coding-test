-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME,
    case
        when (SEX_UPON_INTAKE Like '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%') 
        then 'O' ELSE 'X' 
    END AS '중성화'
from ANIMAL_INS ORDER BY ANIMAL_ID ASC;