package com.haydikodlayalim.repo;

import com.haydikodlayalim.entity.Address;
import com.haydikodlayalim.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { //person entity si ile calissin, person id si long dur
    //burada extends edilen repository i degistirebiliriz ornegin crudrepos yapabiliriz, ancak crudrepo nun islemleri sinirlidir. JpaRepo bunlarin cogunu kapsar
}
