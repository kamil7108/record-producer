package polsl.recordproducer.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleGaugeRecordJPA extends JpaRepository<SingleGaugeRecord, UUID>
{
	SingleGaugeRecord findFirst1ByOrderByTimeStampDesc();
	SingleGaugeRecord findFirst1ByOrderByTimeStampAsc();
}
