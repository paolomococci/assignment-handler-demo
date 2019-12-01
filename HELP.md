# Examples of use:

## employees interface:
```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Paul","lastName":"Do"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:31:16 GMT

{
  "firstName" : "Paul",
  "lastName" : "Do",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/23"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Alice","lastName":"Pickle"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:37:46 GMT

{
  "firstName" : "Alice",
  "lastName" : "Pickle",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/6"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Susan","lastName":"Dash"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:41:03 GMT

{
  "firstName" : "Susan",
  "lastName" : "Dash",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/7"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Victoria","lastName":"Custodian"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:42:59 GMT

{
  "firstName" : "Victoria",
  "lastName" : "Custodian",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/8"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Fiona","lastName":"Surge"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:48:27 GMT

{
  "firstName" : "Fiona",
  "lastName" : "Surge",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/9"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName":"Liz","lastName":"Smart"}' http://localhost:9090/api/employees
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 07:53:33 GMT

{
  "firstName" : "Liz",
  "lastName" : "Smart",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/10"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
```

## employees interface resume:
```
$ curl -v -i http://127.0.0.1:9090/employees
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 07:54:34 GMT
Date: Sun, 01 Dec 2019 07:54:34 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Alice",
      "lastName" : "Pickle",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/6"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/6"
        }
      }
    }, {
      "firstName" : "Susan",
      "lastName" : "Dash",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/7"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/7"
        }
      }
    }, {
      "firstName" : "Victoria",
      "lastName" : "Custodian",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/8"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/8"
        }
      }
    }, {
      "firstName" : "Fiona",
      "lastName" : "Surge",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/9"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/9"
        }
      }
    }, {
      "firstName" : "Liz",
      "lastName" : "Smart",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/10"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/10"
        }
      }
    }, {
      "firstName" : "Paul",
      "lastName" : "Do",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/23"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/23"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/employees{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/employees"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 6,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/employees?sort=lastName
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /employees?sort=lastName HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 07:58:39 GMT
Date: Sun, 01 Dec 2019 07:58:39 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Victoria",
      "lastName" : "Custodian",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/8"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/8"
        }
      }
    }, {
      "firstName" : "Susan",
      "lastName" : "Dash",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/7"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/7"
        }
      }
    }, {
      "firstName" : "Paul",
      "lastName" : "Do",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/23"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/23"
        }
      }
    }, {
      "firstName" : "Alice",
      "lastName" : "Pickle",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/6"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/6"
        }
      }
    }, {
      "firstName" : "Liz",
      "lastName" : "Smart",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/10"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/10"
        }
      }
    }, {
      "firstName" : "Fiona",
      "lastName" : "Surge",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/9"
        },
        "employee" : {
          "href" : "http://127.0.0.1:9090/employees/9"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/employees"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/employees"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 6,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## workOrders interface:
```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123456"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:21:26 GMT

{
  "tag" : "wo123456",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/11"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123458"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:22:25 GMT

{
  "tag" : "wo123458",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/24"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123460"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:23:08 GMT

{
  "tag" : "wo123460",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/25"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123462"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:24:38 GMT

{
  "tag" : "wo123462",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/26"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123464"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:25:07 GMT

{
  "tag" : "wo123464",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/27"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123467"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:25:47 GMT

{
  "tag" : "wo123467",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/28"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"tag":"wo123471"}' http://localhost:9090/api/workOrders
HTTP/1.1 200 
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 08:26:43 GMT

{
  "tag" : "wo123471",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/workOrders/29"
    },
    "workOrders" : {
      "href" : "http://localhost:9090/api/workOrders"
    }
  }
}
```

## workOrders interface resume:

```
$ curl -v -i http://127.0.0.1:9090/workOrders
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /workOrders HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 08:28:17 GMT
Date: Sun, 01 Dec 2019 08:28:17 GMT

< 
{
  "_embedded" : {
    "workOrders" : [ {
      "tag" : "wo123456",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/11"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/11"
        }
      }
    }, {
      "tag" : "wo123458",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/24"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/24"
        }
      }
    }, {
      "tag" : "wo123460",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/25"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/25"
        }
      }
    }, {
      "tag" : "wo123462",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/26"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/26"
        }
      }
    }, {
      "tag" : "wo123464",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/27"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/27"
        }
      }
    }, {
      "tag" : "wo123467",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/28"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/28"
        }
      }
    }, {
      "tag" : "wo123471",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/workOrders/29"
        },
        "workOrder" : {
          "href" : "http://127.0.0.1:9090/workOrders/29"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/workOrders{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/workOrders"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 7,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## some more examples with the workOrders interface:
```
$ curl -v -i http://127.0.0.1:9090/api/workOrders/29
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/workOrders/29 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 08:34:44 GMT
Date: Sun, 01 Dec 2019 08:34:44 GMT

< 
{
  "tag" : "wo123471",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/workOrders/29"
    },
    "workOrders" : {
      "href" : "http://127.0.0.1:9090/api/workOrders"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/api/workOrders
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/workOrders HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 09:38:23 GMT
Date: Sun, 01 Dec 2019 09:38:23 GMT

< 
{
  "_embedded" : {
    "workOrders" : [ {
      "tag" : "wo123456",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/11"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123458",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/24"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123460",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/25"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123462",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/26"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123464",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/27"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123467",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/28"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    }, {
      "tag" : "wo123471",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/workOrders/29"
        },
        "workOrders" : {
          "href" : "http://127.0.0.1:9090/api/workOrders"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

```

## some more examples with the employees interface:
```
$ curl -v -i http://127.0.0.1:9090/api/employees
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 09:40:52 GMT
Date: Sun, 01 Dec 2019 09:40:52 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Alice",
      "lastName" : "Pickle",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/6"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Susan",
      "lastName" : "Dash",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/7"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Victoria",
      "lastName" : "Custodian",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/8"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Fiona",
      "lastName" : "Surge",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/9"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Liz",
      "lastName" : "Smart",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/10"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Paul",
      "lastName" : "Do",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/23"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -i -X PATCH -H "Content-Type:application/json" -d '{"firstName": "Nigel"}' http://localhost:9090/api/employees/23
HTTP/1.1 201 
Location: 23
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 09:50:01 GMT

{
  "firstName" : "Nigel",
  "lastName" : "Do",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/23"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X PUT -H "Content-Type:application/json" -d '{"firstName":"Kevin","lastName":"Smile"}' http://localhost:9090/api/employees/23
HTTP/1.1 201 
Location: 23
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 09:55:13 GMT

{
  "firstName" : "Kevin",
  "lastName" : "Smile",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/23"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X DELETE http://localhost:9090/api/employees/23
HTTP/1.1 204 
Date: Sun, 01 Dec 2019 09:56:21 GMT
$ curl -v -i http://127.0.0.1:9090/api/employees
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 09:58:20 GMT
Date: Sun, 01 Dec 2019 09:58:20 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Alice",
      "lastName" : "Pickle",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/6"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Susan",
      "lastName" : "Dash",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/7"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Victoria",
      "lastName" : "Custodian",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/8"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Fiona",
      "lastName" : "Surge",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/9"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Liz",
      "lastName" : "Smart",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/10"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/api/employees/23
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees/23 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 10:27:31 GMT
Date: Sun, 01 Dec 2019 10:27:31 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{ }
$ curl -i -X PATCH -H "Content-Type:application/json" -d '{"firstName": "Nigel"}' http://localhost:9090/api/employees/23
HTTP/1.1 201 
Location: 30
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 10:35:55 GMT

{
  "firstName" : "Nigel",
  "lastName" : null,
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/30"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -i -X PUT -H "Content-Type:application/json" -d '{"firstName":"Kevin","lastName":"Smile"}' http://localhost:9090/api/employees/23
HTTP/1.1 201 
Location: 31
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 01 Dec 2019 10:37:10 GMT

{
  "firstName" : "Kevin",
  "lastName" : "Smile",
  "jobs" : [ ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:9090/api/employees/31"
    },
    "employees" : {
      "href" : "http://localhost:9090/api/employees"
    }
  }
}
$ curl -v -i http://127.0.0.1:9090/api/employees/23
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees/23 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 10:37:53 GMT
Date: Sun, 01 Dec 2019 10:37:53 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{ }
$ curl -v -i http://127.0.0.1:9090/api/employees
*   Trying 127.0.0.1:9090...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 01 Dec 2019 10:38:28 GMT
Date: Sun, 01 Dec 2019 10:38:28 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Alice",
      "lastName" : "Pickle",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/6"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Susan",
      "lastName" : "Dash",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/7"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Victoria",
      "lastName" : "Custodian",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/8"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Fiona",
      "lastName" : "Surge",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/9"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Liz",
      "lastName" : "Smart",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/10"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Nigel",
      "lastName" : null,
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/30"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    }, {
      "firstName" : "Kevin",
      "lastName" : "Smile",
      "jobs" : [ ],
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/31"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
