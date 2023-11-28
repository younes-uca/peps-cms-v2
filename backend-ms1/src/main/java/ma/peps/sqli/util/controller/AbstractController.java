package ma.peps.sqli.util.controller;

import jakarta.servlet.http.HttpServletRequest;
import ma.peps.sqli.util.converter.AbstractConverter;
import ma.peps.sqli.util.criteria.BaseCriteria;
import ma.peps.sqli.util.domain.AuditDomainObject;
import ma.peps.sqli.util.dto.BaseDto;
import ma.peps.sqli.util.exception.GlobalException;
import ma.peps.sqli.util.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;


public class AbstractController<T extends AuditDomainObject, DTO extends BaseDto, Criteria extends BaseCriteria, SERV extends IService<T, Criteria>, CONV extends AbstractConverter<T, DTO>> {
    protected SERV service;
    protected AbstractConverter<T, DTO> converter;
    @Autowired
    private MessageSource messageSource;

    public List<DTO> findDtos(List<T> list) {
        converter.initList(false);
        List<DTO> dtos = converter.toDto(list);
        return dtos;
    }

    public ResponseEntity<DTO> findById(Long id, String[] includes, String[] excludes) throws Exception {
        ResponseEntity<DTO> result = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        T t = service.findById(id);
        if (t != null) {
            converter.init(true);
            DTO dto = converter.toDto(t);
            result = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
        return result;
    }


    public ResponseEntity<DTO> save(DTO dto) throws Exception {
        ResponseEntity<DTO> result;
        if (dto != null) {
            converter.init(true);
            T myT = converter.toItem(dto);
            T t = service.save(myT);
            if (t == null) {
                result = new ResponseEntity(null, HttpStatus.IM_USED);
            } else {
                DTO myDto = converter.toDto(t);
                result = new ResponseEntity(myDto, HttpStatus.CREATED);
            }
        } else {
            result = new ResponseEntity(dto, HttpStatus.NO_CONTENT);
        }
        return result;
    }


    public ResponseEntity<DTO> update(DTO dto) throws Exception {
        ResponseEntity<DTO> res;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            T t = converter.toItem(dto);
            T updated = service.update(t);
            DTO myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }


    protected ResponseEntity<Integer> deleteById(Long id) throws Exception {
        ResponseEntity<Integer> res;
        Integer resultDelete = 0;
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        if (id != null) {
            resultDelete = service.deleteById(id);
            if (resultDelete > 0) {
                status = HttpStatus.OK;
            }
        }
        res = new ResponseEntity<>(resultDelete, status);
        return res;
    }


    public ResponseEntity<List<DTO>> findAll() throws Exception {
        List<DTO> dtos = null;
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<T> list = service.findAll();
        converter.initObject(true);
        converter.initList(false);
        dtos = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        return new ResponseEntity<>(dtos, status);
    }


    public ResponseEntity<List<DTO>> findAllOptimized() throws Exception {
        List<DTO> dtos = null;
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<T> list = service.findAllOptimized();
        dtos = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        return new ResponseEntity<>(dtos, status);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e, HttpServletRequest request) throws IOException {
        GlobalException globalException = new GlobalException(e, messageSource, request.getRequestURI());
        ErrorResponse errorResponse = new ErrorResponse(globalException.getStatus(), e, globalException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, globalException.getStatus());
    }

    public AbstractController(SERV service, CONV converter) {
        this.service = service;
        this.converter = converter;
    }
}
