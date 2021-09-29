package com.haydikodlayalim.service.Impl;

import com.haydikodlayalim.dto.PersonDto;
import com.haydikodlayalim.entity.Address;
import com.haydikodlayalim.entity.Person;
import com.haydikodlayalim.repo.AddressRepository;
import com.haydikodlayalim.repo.PersonRepository;
import com.haydikodlayalim.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    /*
        Service
        Repository
        RestController
        Controller
        bunlari goren spring otomatik nesne uretir
     */
    private final PersonRepository personRepository; //final oldugu icin constructor dan deger atanmali, bunu anliyor
    private final AddressRepository addressRepository;

    @Override
    @Transactional //islemin tamamini bir seferde yapar ya da yapmaz
    public PersonDto save(PersonDto personDto) {

        Assert.isNull(personDto.getName(), "isim alani zorunludur"); //isim zorunlu yoksa exception firlatiyor
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);
        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setPerson(personDb);
            addressList.add(address);
        });

        addressRepository.saveAll(addressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll()
    {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        persons.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAddresses(item.getAddresses().stream()
                    .map(Address::getAddress).collect(Collectors.toList())); //adreslerin hepsinin sadece adres kolonlarini al
            personDtoList.add(personDto);
        });
        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
